package heavy.dataBase.optional;

import heavy.dataBase.ConnectionDb;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import heavy.domain.optional.Agency;

public class AgencyQuery {

    private static final String sql_select = "SELECT * FROM VW_Select_Agency";

    private static final String sql_select_by_Shipping = "EXEC USP_ViewAgency_by_Shipping ?";

    public List<Agency> select() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Agency agency = null;
        List<Agency> agencys = new ArrayList<>();

        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                short agencyId = resultSet.getShort("AgencyID");
                String agencyAddess = resultSet.getString("AgencyAddress");
                float normalPrice = resultSet.getFloat("NormalPrice");
                float expressPrice = resultSet.getFloat("ExpressPrice");
                byte agencyDay = resultSet.getByte("AgencyDay");
                short districtId = resultSet.getShort("DistrictID");
                short shippingCompanyId = resultSet.getShort("ShippingCompanyID");

                agency = new Agency(agencyId, agencyAddess, normalPrice, expressPrice, agencyDay, districtId, shippingCompanyId);
                agencys.add(agency);                
            }

        } catch (SQLException e) {
            ConnectionDb.processEception(e);
        } finally {
            ConnectionDb.close(resultSet);
            ConnectionDb.close(preparedStatement);
            ConnectionDb.close(connection);
        }
        return agencys;
    }
    
    
    public List<Agency> selectAgency(Agency agency) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Agency> agencys = new ArrayList<>();
        try {
            connection = ConnectionDb.getConnection();
            preparedStatement = connection.prepareStatement(sql_select_by_Shipping);
            preparedStatement.setShort(1, agency.getShippingCompanyId());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                short agencyId = resultSet.getShort("AgencyID");
                String agencyAddess = resultSet.getString("AgencyAddress");
                float normalPrice = resultSet.getFloat("NormalPrice");
                float expressPrice = resultSet.getFloat("ExpressPrice");
                byte agencyDay = resultSet.getByte("AgencyDay");
                short districtId = resultSet.getShort("DistrictID");
                short shippingCompanyId = resultSet.getShort("ShippingCompanyID");
                agency = new Agency(agencyId, agencyAddess, normalPrice, expressPrice, agencyDay, districtId, shippingCompanyId);              
                agencys.add(agency);
            }

        } catch (SQLException e) {
            ConnectionDb.processEception(e);
        } finally {
                ConnectionDb.close(resultSet);
                ConnectionDb.close(preparedStatement);
                ConnectionDb.close(connection);
        }
        return agencys;
    }      
}
