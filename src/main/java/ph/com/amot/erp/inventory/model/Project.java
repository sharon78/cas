package ph.com.amot.erp.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;

@SuppressWarnings("serial")
public class Project
	implements Serializable {

    @Column(name = "SEQ", nullable = false)
    private String seq;

    private Long id;
    private String name;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String city;
    private Long mapLongitude;
    private Long mapLatitude;
    private double totalAmount;

}
