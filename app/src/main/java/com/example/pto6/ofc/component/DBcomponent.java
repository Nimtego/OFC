package com.example.pto6.ofc.component;

import com.example.pto6.ofc.service.DBHelper;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = DatabaseModule.class)
public interface DBcomponent {
    DBHelper getDBhelper();
}
