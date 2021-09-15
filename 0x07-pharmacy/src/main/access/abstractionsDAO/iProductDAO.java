package main.access.abstractionsDAO;

import main.model.products.ProductModel;

/**
 * Interface DAO that interitance iDAO<T, K> interface.
 * Assign concrete values to the iDAO<ProductModel, Long>
 * 
 * @param ProductModel Datatype model
 * @param Long Datatype id
 */
public interface iProductDAO extends iDAO<ProductModel, Long> {}
