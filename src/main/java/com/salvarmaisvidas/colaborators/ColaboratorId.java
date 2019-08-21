package com.salvarmaisvidas.colaborators;

import java.io.Serializable;

public class ColaboratorId implements Serializable {
    private int id;
    private String name;

    public ColaboratorId(){
    }

    public ColaboratorId(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ColaboratorId cId = (ColaboratorId) obj;

        if (id != cId.id || !name.equals(cId.name)) return false;
        return true;
    }

    @Override
    public int hashCode(){
        return (int) id + name.hashCode();
    }
}
