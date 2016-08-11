package ph.com.amot.erp.inventory.model;

import java.io.Serializable;

import javax.persistence.Column;

@SuppressWarnings("serial")
public class Client
	implements Serializable {

    @Column(name = "SEQ", nullable = false)
    private String seq;

    private Long id;
    private String name;
}
