package com.ryanchambers.devicedata.dao;

import com.ryanchambers.devicedata.model.BitFunction;

import java.util.List;

public interface BitFunctionDao {

    List<BitFunction> getAll();

    void create(BitFunction bitFunction);

}
