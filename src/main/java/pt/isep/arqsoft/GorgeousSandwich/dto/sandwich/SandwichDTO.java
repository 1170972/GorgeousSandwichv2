package pt.isep.arqsoft.GorgeousSandwich.dto.sandwich;

public class SandwichDTO {

    private Integer stock;

    private String type;

    private String designation;

    private String description;

    private Long sandwichId;

    public SandwichDTO(){

    }

    public SandwichDTO(Integer stock, String type, String designation, String description) {
        this.stock = stock;
        this.type = type;
        this.designation = designation;
        this.description = description;
    }

    public SandwichDTO(Long sandwichId, Integer stock, String type, String designation, String description) {
        this.sandwichId = sandwichId;
        this.stock = stock;
        this.type = type;
        this.designation = designation;
        this.description = description;
    }

    public Integer obtainStock() {
        return stock;
    }

    public String obtainType() {
        return type;
    }

    public String obtainDesignation() {
        return designation;
    }

    public String obtainDescription() {
        return description;
    }

    public Long obtainSandwichId() {
        return sandwichId;
    }
}
