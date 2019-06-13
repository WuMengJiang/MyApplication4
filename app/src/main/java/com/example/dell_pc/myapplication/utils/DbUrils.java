package com.example.dell_pc.myapplication.utils;

import com.example.dell_pc.myapplication.bean.Students;
import com.example.dell_pc.myapplication.dao.DaoMaster;
import com.example.dell_pc.myapplication.dao.StudentsDao;

import java.util.ArrayList;
import java.util.List;

public class DbUrils {
    private static DbUrils dbUrils;
    private final StudentsDao dao;

    private DbUrils() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(MyApp.getMyApp(), "my.db");
        dao = new DaoMaster(helper.getWritableDatabase()).newSession().getStudentsDao();
    }

    public static DbUrils getDbUrils() {
        if (dbUrils == null) {
            synchronized (DbUrils.class){
                if (dbUrils == null) {
                    dbUrils = new DbUrils();
                }
            }
        }
        return dbUrils;
    }
    public void  insert(Students students){
        if (!has(students)){
            dao.insertOrReplaceInTx(students);
        }
    }
    public List<Students> qurey (){
        List<Students> list = dao.queryBuilder().list();
        return list;
    }
    private boolean has(Students students) {
        List<Students> list = dao.queryBuilder().where(StudentsDao.Properties.Text.eq(students.getText()), StudentsDao.Properties.Thumbnail.eq(students.getThumbnail()), StudentsDao.Properties.Top_comments_header.eq(students.getTop_comments_header())).list();
        if (list!=null&&list.size()>0){
            return true;
        }
        return false;
    }

}
