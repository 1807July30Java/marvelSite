package com.revature.dao;

import com.revature.beans.Bear;

import java.util.List;

public interface BearDAO {
    public List<Bear> getBears();

    public Bear getBearByID(int ID);

    public int addBear(Bear b);

    public void updateBear(Bear b);

    public void deleteBear(Bear b);
}
