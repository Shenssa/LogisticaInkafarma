package com.logistica.proyecto.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.logistica.proyecto.entidad.DetalleCompra;
import com.logistica.proyecto.interfaces.InterfacesSimple;
import com.logistica.proyecto.jdbc.ConnectionServer;
import com.logistica.proyecto.servicio.impl.IDetalleCompra;

@Service
public class DetalleCompraServicioImp implements InterfacesSimple<DetalleCompra> {
	@Autowired
	private IDetalleCompra DAO;

	@Override
	public List<DetalleCompra> obtenerLista() {
		return (List<DetalleCompra>) DAO.findAll();

	}

	@Override
	public void guardar(DetalleCompra obj) {
		DAO.save(obj);

	}

	@Override
	public void eliminar(Integer id) {
		DAO.deleteById(id);

	}

	@Override
	public DetalleCompra BuscarPorIdEntidad(Integer id) {
		return DAO.findById((Integer) id).orElse(null);

	}

	@Override
	public boolean existe(Integer id) {
		return DAO.existsById(id);
	}

	public boolean guardarTodo(List<DetalleCompra> obj) {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean resp = false;
		try {
			connection = new ConnectionServer().getConnection();
			System.err.println("CONECTADO");

			for (DetalleCompra detalleCompra : obj) {
				ps = connection
						.prepareStatement("INSERT INTO detalle_compra (id_compra,cantidad,id_producto) VALUES(?,?,?)");
				ps.setInt(1, detalleCompra.getIdCompra());
				ps.setInt(2, detalleCompra.getCantidad());
				ps.setInt(3, detalleCompra.getProducto().getIdProducto());
			}

			if (ps.executeUpdate() > 0) {
				resp = true;
			}

			return resp;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resp;

	}

	static public Integer select() {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
	 

		try {
			connection = new ConnectionServer().getConnection();
			System.err.println("CONECTADO");
			String sql = "SELECT id_compra  FROM  detalle_compra ORDER by id_compra  DESC limit 1";
            
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
		    if (rs.next()) {
				return rs.getInt("id_compra") ;
			}
			 
        } catch (SQLException e) {
			e.printStackTrace();
		}
		return -66666;

	}

	static public void INSERTCompra() {
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int ok = 0;

		try {
			connection = new ConnectionServer().getConnection();
			System.err.println("CONECTADO");
			ps = connection.prepareStatement("INSERT INTO compra (id_compra, total) VALUES (NULL, 0)");
			ok = ps.executeUpdate();
			System.err.println("EJECUTO");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
