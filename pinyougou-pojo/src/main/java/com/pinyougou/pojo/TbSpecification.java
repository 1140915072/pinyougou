package com.pinyougou.pojo;

import java.io.Serializable;
import java.util.List;

public class TbSpecification implements Serializable {
    private static final long serialVersionUID = -5963544798517861298L;

	private Long id;

    private String specName;

    private List<TbSpecificationOption> specList;

    public List<TbSpecificationOption> getSpecList() {
        return specList;
    }

    public void setSpecList(List<TbSpecificationOption> specList) {
        this.specList = specList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName == null ? null : specName.trim();
    }
}