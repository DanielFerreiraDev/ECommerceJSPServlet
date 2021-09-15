package br.edu.ifce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ifce.beans.Produto;
import br.edu.ifce.utils.DbUtil;

public class ProdutoDao {
	private Connection connection;
	
	public ProdutoDao() {
		connection = DbUtil.getConnection();
	}
	
	public List<Produto> getAllProducts() {
		List<Produto> listaDeProdutos = new ArrayList<Produto>();
		String sql = "SELECT * FROM produtos";
		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getInt("valor"));
				produto.setQuantidade(rs.getInt("quantidade"));
				listaDeProdutos.add(produto);
			}
			st.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return listaDeProdutos;
		
	}
	
	public void addProducts(Produto produto) {
		String sql = "INSERT INTO produtos (nome, valor) VALUES (?,?)";
		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, produto.getNome());
			st.setInt(2, produto.getValor());
			st.executeUpdate();
			st.close();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void updateProducts(Produto produto) {
		String sql = "UPDATE produtos SET quantidade=? WHERE id=?";
		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, produto.getQuantidade());
			st.setInt(2, produto.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public Produto getProdutoById(int id) {
		Produto produto = new Produto();
		String sql = "SELECT * FROM produtos WHERE id=?";
		
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			
			if(rs.next()) {
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setValor(rs.getInt("valor"));
				produto.setQuantidade(rs.getInt("quantidade"));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return produto;
	}
	

}
