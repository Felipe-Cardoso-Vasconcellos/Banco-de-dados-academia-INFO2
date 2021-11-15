
package com.mycompany.academia.dao;

import com.mycompany.academia.dao.conexao.Conexao;
import com.mycompany.academia.model.Funcionarios;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class FuncionarioDAO {
    
    public void inserirFuncionario(Funcionarios f){
        try {
            String SQL = "INSERT INTO funcionario (cpf, nome, idade, telefone ) VALUES (?, ?, ?, ?)";
            Connection minhaConexao = Conexao.getConexao();
            PreparedStatement comando = minhaConexao.prepareStatement(SQL);
            comando.setString(0, f.getCpf());
            comando.setString(1, f.getNome());
            comando.setInt(2, f.getIdade());
            comando.setString(3, f.getTelefone());
            int retorno = comando.executeUpdate();
            if(retorno>0){
                JOptionPane.showMessageDialog(null, "Funcionário "+ f.getNome()+ " registrado!");
            } else {
                JOptionPane.showMessageDialog(null, "Erro ao registrar "+ f.getNome());
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
