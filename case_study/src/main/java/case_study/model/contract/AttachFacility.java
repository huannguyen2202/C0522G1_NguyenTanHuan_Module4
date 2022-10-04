package case_study.model.contract;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AttachFacility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attachFacilityId;
    private String attachFacilityName;
    private String attachFacilityCost;
    private String attachFacilityUnit;
    private String attachFacilityStatus;

    @OneToMany(mappedBy = "attachFacility")
    private Set<ContractDetail> contractDetail;

    public AttachFacility() {
    }

    public AttachFacility(Integer attachFacilityId, String attachFacilityName,
                          String attachFacilityCost, String attachFacilityUnit,
                          String attachFacilityStatus, Set<ContractDetail> contractDetail) {
        this.attachFacilityId = attachFacilityId;
        this.attachFacilityName = attachFacilityName;
        this.attachFacilityCost = attachFacilityCost;
        this.attachFacilityUnit = attachFacilityUnit;
        this.attachFacilityStatus = attachFacilityStatus;
        this.contractDetail = contractDetail;
    }

    public Integer getAttachFacilityId() {
        return attachFacilityId;
    }

    public void setAttachFacilityId(Integer attachFacilityId) {
        this.attachFacilityId = attachFacilityId;
    }

    public String getAttachFacilityName() {
        return attachFacilityName;
    }

    public void setAttachFacilityName(String attachFacilityName) {
        this.attachFacilityName = attachFacilityName;
    }

    public String getAttachFacilityCost() {
        return attachFacilityCost;
    }

    public void setAttachFacilityCost(String attachFacilityCost) {
        this.attachFacilityCost = attachFacilityCost;
    }

    public String getAttachFacilityUnit() {
        return attachFacilityUnit;
    }

    public void setAttachFacilityUnit(String attachFacilityUnit) {
        this.attachFacilityUnit = attachFacilityUnit;
    }

    public String getAttachFacilityStatus() {
        return attachFacilityStatus;
    }

    public void setAttachFacilityStatus(String attachFacilityStatus) {
        this.attachFacilityStatus = attachFacilityStatus;
    }

    public Set<ContractDetail> getContractDetail() {
        return contractDetail;
    }

    public void setContractDetail(Set<ContractDetail> contractDetail) {
        this.contractDetail = contractDetail;
    }
}
