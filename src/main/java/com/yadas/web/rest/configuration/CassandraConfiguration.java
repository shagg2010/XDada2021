package com.yadas.web.rest.configuration;

import com.datastax.oss.driver.api.core.CqlSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Configuration
public class CassandraConfiguration extends AbstractCassandraConfiguration {

    @Value("${application.cassandra.keyspace}")
    private String cassandraKeyspaceName;

    @Value("${application.cassandra.contact-point}")
    private String cassandraContactPoint;

    @Value("${application.cassandra.datacenter}")
    private String cassandraDatacenter;

    @Override
    protected String getKeyspaceName() {
        return this.cassandraKeyspaceName;
    }

    @Override
    protected String getLocalDataCenter() {
        return this.cassandraDatacenter;
    }

    @Override
    protected String getContactPoints() {
        return this.cassandraContactPoint;
    }

    /*@Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = null;
        try{
            specification = CreateKeyspaceSpecification.createKeyspace(this.cassandraKeyspaceName);
        }
        catch(Exception e){
            System.out.println("ERROR: Cassandra keystore creation failed.");
            //handle here
        }
        if(Objects.isNull(specification)){
            return Arrays.asList();
        }
        return Arrays.asList(specification);
    }*/
     /*
     //Use the standard Cassandra driver API to create a com.datastax.oss.driver.api.core.CqlSession instance.
    @Bean
    public CqlSession session() {
        return CqlSession.builder().withKeyspace("store").build();
    }*/

}
