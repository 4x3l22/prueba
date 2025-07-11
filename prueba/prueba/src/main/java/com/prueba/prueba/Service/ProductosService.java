package com.prueba.prueba.Service;

import com.prueba.prueba.Dto.ProductosDto;
import com.prueba.prueba.Dto.TransferenciaDto;
import com.prueba.prueba.Entity.Clientes;
import com.prueba.prueba.Entity.Productos;
import com.prueba.prueba.Entity.Transferencia;
import com.prueba.prueba.Repository.IBaseRepository;
import com.prueba.prueba.Repository.ProductosRepository;
import com.prueba.prueba.IService.IProductosService;
import com.prueba.prueba.Repository.TransaccionesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Random;
import java.util.Optional;

@Service
public class ProductosService extends BaseService<Productos> implements IProductosService {

    private final ProductosRepository productosRepository;
    private final AuditoriaService auditoriaService;
    private final TransaccionesRepository transaccionesRepository;

    protected ProductosService(IBaseRepository<Productos, Long> repository, AuditoriaService auditService, ProductosRepository productosRepository, AuditoriaService auditoriaService, TransaccionesRepository transaccionesRepository) {
        super(repository, auditService);
        this.productosRepository = productosRepository;
        this.auditoriaService = auditoriaService;
        this.transaccionesRepository = transaccionesRepository;
    }

    public void saveProductos(ProductosDto productosDto) throws Exception{

        long numeroCuenta;

        do{
            numeroCuenta = numeroRandom(productosDto.getTipCuenta());
        }while (productosRepository.existsByNumCuenta(numeroCuenta));

        Productos productos = new Productos();
        Clientes cliente = new Clientes();

        cliente.setId(productosDto.getIdCliente());

        productos.setFechaCreacion(productosDto.getFechaCreacion());
        productos.setFechaModificacion(productosDto.getFechaModificacion());
        productos.setClientes(cliente);
        productos.setSaldo(productosDto.getSaldo());
        productos.setTipCuenta(productosDto.getTipCuenta());
        productos.setNumCuenta(numeroCuenta);
        productos.setEstado("activo");
        productos.setExentaGmf(productosDto.getExentaGmf());

        if(productosDto.getTipCuenta().equalsIgnoreCase("ahorros") && productosDto.getSaldo() <= 0){
            throw new Exception("Para crear la cuenta se debe registrar 5 mil por lo menos de fondo");
        }

        super .save(productos);
    }

    private long numeroRandom(String tipoCuenta){

        Random rand = new Random();
        long min = 10000000;
        long max = 99999999;
        long numAleatorio = min + rand.nextLong(max);

        String prefijo;
        if ("ahorros".equalsIgnoreCase(tipoCuenta)) {
            prefijo = "53";
        } else if ("corriente".equalsIgnoreCase(tipoCuenta)) {
            prefijo = "33";
        } else {
            throw new IllegalArgumentException("Tipo de cuenta inválido: " + tipoCuenta);
        }

        return Long.parseLong(prefijo + numAleatorio);
    }

    public void updateProductos(Long id, ProductosDto productosDto) throws Exception {
        Optional<Productos> optionalProducto = productosRepository.findById(id);

        if (optionalProducto.isEmpty()) {
            throw new Exception("No se encontró el producto con ID: " + id);
        }

        if("cancelado".equalsIgnoreCase(productosDto.getEstado()) && productosDto.getSaldo() <= 0){
            throw new Exception("Para cancelar la cuenta no debes tener fondos");
        }

        Productos productoToUpdate = optionalProducto.get();

        // Copiar propiedades válidas desde el DTO a la entidad, ignorando campos protegidos
        String[] ignoreProperties = { "id", "fechaCreacion", "fechaEliminacion", "numCuenta", "idCliente"};
        BeanUtils.copyProperties(productosDto, productoToUpdate, ignoreProperties);

        // Auditar modificación
        auditoriaService.setAuditoriaOnUpdate(productoToUpdate);

        // Guardar
        productosRepository.save(productoToUpdate);
    }

    @Transactional
    public void transferir(TransferenciaDto dto) throws Exception {
        // 1. Buscar ambas cuentas
        Productos origen = productosRepository.findByNumCuenta(dto.getCuentaOrigen())
                .orElseThrow(() -> new Exception("Cuenta origen no encontrada"));

        Productos destino = productosRepository.findByNumCuenta(dto.getCuentaDestino())
                .orElseThrow(() -> new Exception("Cuenta destino no encontrada"));

        // 2. Validar que no sean la misma cuenta
        if (origen.getNumCuenta() == destino.getNumCuenta()) {
            throw new Exception("No se puede transferir a la misma cuenta");
        }

        // 3. Validar saldo suficiente
        if (origen.getSaldo() < dto.getValor()) {
            throw new Exception("Saldo insuficiente en la cuenta origen");
        }

        // 4. Aplicar la transferencia (ajuste de saldos)
        origen.setSaldo(origen.getSaldo() - dto.getValor());
        destino.setSaldo(destino.getSaldo() + dto.getValor());

        // 5. Crear el registro de la transferencia
        Transferencia transferencia = new Transferencia();
        transferencia.setCuentaOrigen(origen);
        transferencia.setCuentaDestino(destino);
        transferencia.setValorTransferencia(dto.getValor());
        transferencia.setTipoTransferencia(dto.getTipoTransferencia());

        ZonedDateTime bogotaNow = ZonedDateTime.now(ZoneId.of("America/Bogota"));
        transferencia.setFechaCreacion(bogotaNow.toLocalDateTime());

        // 6. Guardar todo
        productosRepository.save(origen);
        productosRepository.save(destino);
        transaccionesRepository.save(transferencia);
    }



}