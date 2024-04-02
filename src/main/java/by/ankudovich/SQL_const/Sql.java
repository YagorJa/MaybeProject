package by.ankudovich.SQL_const;

public class Sql {
    public static final String ADD_USER = "insert into project.user (id, \"name\",surname,role, login, password) " + "values (?,?,?,?,?,?)";
    public static final String DELETE_USER_BY_ID = "DELETE FROM project.user WHERE id = ?";
    public static final String SELECT_ALL_USERS = "SELECT * FROM project.user";
    public static final String SELECT_USER_BY_ID = "SELECT * FROM project.user WHERE id = ?";
    public static final String SELECT_USER_BY_LOGIN = "SELECT * FROM project.user WHERE login = ?";
    public static final String SELECT_MAX_ID = "SELECT max(id) FROM project.user";
    public static final String ADD_PRODUCT = "insert into project.product (id, \"name\",code, price, quantity,type_role) " + "values (?,?,?,?,?,?)";
    public static final String MAX_ID = "select max(id) from project.product";
    public static final String SELECT_PRODUCT_BY_NAME_AND_TYPE_AND_PRICE = "SELECT id, quantity FROM project.product WHERE \"name\" = ? AND type = ? AND price = ?";
    public static final String UPDATE_QUANTITY = "UPDATE project.product SET quantity = ? WHERE id = ?";
    public static final String DELETE_PRODUCT_BY_ID = "DELETE FROM project.product WHERE id = ?";
    public static final String SELECT_PRODUCT_BY_ID = "SELECT * FROM project.product WHERE id = ?";
    public static final String SELECT_ALL_PRODUCTS = "SELECT * FROM project.product ORDER BY id";
    public static final String SELECT_PRODUCT_BY_NAME = "SELECT * FROM project.product WHERE name = ?";
    public static final String SELECT_PRODUCTS_BY_IDS = "SELECT * FROM project.product WHERE id = ANY(?)";
    public static final String SELECT_PRODUCT_QUANTITY_BY_ID = "SELECT quantity FROM project.product WHERE id = ?";
    public static final String SELECT_MAX_BASKET_ID = "select max(id) from project.basket";
    public static final String INSERT_INTO_BASKETS = "insert into project.basket(id, productid, orderid , count)  " + "values (?,?,?,?)";
    public static final String SELECT_PRODUCT_QUANTITY = "SELECT quantity from project.basket WHERE id = ?";
    public static final String UPDATE_ORDER_STATUS = "UPDATE project.basket SET status = ? WHERE userid = ?";
    public static final String SELECT_PRODUCTS_AND_QUANTITIES = "SELECT productid, count FROM project.basket WHERE orderid IN (SELECT id FROM project.order WHERE userid = ?)";
    public static final String UPDATE_PRODUCT_QUANTITIES = "UPDATE project.product SET quantity = quantity - ? WHERE id = ?";
    public static final String SELECT_BASKETS_BY_ORDER_ID = "SELECT * from project.basket WHERE orderid = ?";
    public static final String SELECT_ORDER_STATUS = "select status from project.order WHERE id = ?";
    public static final String SELECT_PRODUCT_QUANTITIES = "SELECT quantity from project.product WHERE id = ANY(?)";
    public static final String DELETE_FROM_BASKETS = "DELETE FROM project.basket where orderid = ?";
    public static final String DELETE_FROM_ORDERS = "DELETE FROM project.order WHERE id = ?";
    public static final String DELETE_ALL_FROM_BASKETS = "DELETE FROM project.basket";
    public static final String DELETE_ALL_FROM_ORDERS = "DELETE FROM project.order WHERE status = 'ORDERING'";
    public static final String SELECT_MAX_ID_QUERY = "SELECT max(id) FROM project.order";
    public static final String INSERT_ORDER_QUERY = "insert into project.order(id, userid, cost, status)  " + "values (?,?,?,?)";
    public static final String SELECT_ORDER_BY_USER_ID_QUERY = "SELECT * FROM project.order WHERE userid = ? AND status = 'ORDERING'";
    public static final String SELECT_COST_BY_ORDER_ID_QUERY = "SELECT cost FROM project.order WHERE id = ?";
    public static final String UPDATE_ORDER_COST_QUERY = "UPDATE project.order SET cost = ? WHERE id = ?";
    public static final String UPDATE_USER = "UPDATE project.user SET name = ?, surname = ?, password = ?, login = ? WHERE id = ?";
}
