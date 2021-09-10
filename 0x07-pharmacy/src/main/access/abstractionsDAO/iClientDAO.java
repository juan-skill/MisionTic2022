package main.access.abstractionsDAO;

import main.model.users.ClientModel;

/**
 * Interface DAO that interitance iDAO<T, K> interface.
 * Assign concrete values to the iDAO<ClientModel, Long>
 * 
 * @param ClienteModel Datatype model
 * @param Long Datatype id
 */
public interface iClientDAO extends iDAO<ClientModel, Long> { }
