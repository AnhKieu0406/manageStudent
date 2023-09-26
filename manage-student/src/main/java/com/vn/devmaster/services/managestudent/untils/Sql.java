package com.vn.devmaster.services.managestudent.untils;

public class Sql {
    public  static  final String STUDENT_FILER_BY_CLASS = "" +
            "select s.id, CONCAT(s.first_name,' ',s.last_name)  name ," +
            "s.first_name firstName ," +
            " a.city  city," +
            " ss.point point " +
            "from Student  s" +
            " inner join adress a on a.id = s.id_address " +
            "inner join student_subject ss on  ss.id_student =s.id ";


    public static final  String STUDENT_AVG = ""+
    "select s.id id,"+
    "concat(s.first_name,' ', last_name) name,"+
     " AVG(ss.point) as avg " +
    " from student s " +
    " inner join student_subject ss on ss.id_student = s.id "+
    " group by s.id ";

    public static  final  String SUBJECT_AVG=
            "select s.id id,\n" +
            "       s.name className,\n" +
            "       avg(ss.point) Avg\n" +
            "from subject s\n" +
            "         inner join student_subject ss on s.id = ss.id_subject\n" +
            "\n" +
            "group by s.id, s.name";


    public static  final  String STUDENT_MAX_POINT =
            "select  s.id id,\n" +
                    "        concat(s.first_name, ' ', last_name) name,\n" +
                    "        MAX(ss.point) max \n" +
                    "        from  student s\n" +
                    "inner join student_subject ss on s.id = ss.id_student\n" +
                    "group by  s.id";

    public static  final String STUDENT_HOCBONG = "select s.id                                 id,\n" +
            "       sb.name                              className,\n" +
            "       concat(s.first_name, ' ', last_name) name,\n" +
            "       AVG(ss.point) as                     avg \n" +
            "from student s\n" +
            "         inner join student_subject ss on ss.id_student = s.id\n" +
            "         inner JOIN subject sb on ss.id_subject = sb.id\n" +
            "group by s.id, sb.name\n" +
            "HAVING AVG(SS.point) > 5\n" +
            "limit 1;";

    public static final String STUDENT_POINT_MIN = ""+
            "Select s.id id,\n" +
            "       s.first_name  firstName,\n" +
            "       min(ss.point) as point\n" +
            "from student s\n" +
            "         join student_subject ss on s.id = ss.id_student\n" +
            "group by s.id, s.first_name";
}
