import com.mizpiz.biz.HibernateUtil;
import com.mizpiz.biz.MizpizException;
import com.mizpiz.biz.crud.EntityDao;
import com.mizpiz.biz.crud.InstanceDao;
import com.mizpiz.biz.crud.PropertyDao;
import com.mizpiz.biz.crud.ValueDao;
import com.mizpiz.presist.obj.Instance;
import com.mizpiz.presist.obj.Myentity;
import com.mizpiz.presist.obj.Property;
import com.mizpiz.presist.obj.SubValues.StringVal;
import com.mizpiz.presist.obj.Value;
import javafx.beans.property.SetProperty;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by The Killer on 16/03/14.
 */
public class Main {


    public static void main(String[] args) throws MizpizException {
        new Main().testInstance();
        //    CRUD crud = new CRUD();
        //      crud.entityDao.deleteEntity(1);
        //     new Main().testInstance();
        //   new Main().testInstance();
        //   System.out.print("Done!");
    }

    public void printProperty() {
        Property p1 = new Property();
        Session session = HibernateUtil.getSessionFactory().openSession();
        org.hibernate.Transaction transaction = session.beginTransaction();
        p1 = (Property) session.load(Property.class, 1);
        System.out.print(p1.toString());
    }

    public void MakeDEfaultEntity() throws MizpizException {
        Myentity e1 = new Myentity();
        Property p1 = new Property();
        Property p2 = new Property();
        p1.setType("String");
        p2.setType("String");
        p1.setName("price");
        p2.setName("Brand");
        e1.setName("bicycle");
        long id = 0;
           id=PropertyDao.loadbyNandT(p1);
        if (id != 0)
            p1 = PropertyDao.loadbyID(id);
        else
            try {
                PropertyDao.createProperty(p1);
            } catch (MizpizException e) {
                e.printStackTrace();
                System.out.print("e");
            }

      //  System.out.print(p2.toString());
        id = PropertyDao.loadbyNandT(p2);
        if (id != 0)
            p2 = PropertyDao.loadbyID(id);
        else
            try {
                PropertyDao.createProperty(p2);
            } catch (MizpizException e) {
                e.printStackTrace();
                System.out.print("e");
            }
        System.out.print("SAVED PROPERTY is" + p2.toString());
        Set<Property> propertySet = new HashSet<Property>();
        propertySet.add(p1);
        propertySet.add(p2);
        e1.setProperties(propertySet);
        id = EntityDao.loadbyName(e1.name);
        if (id != 0)
            e1 = EntityDao.loadbyID(id);
        else try {

            EntityDao.createEntity(e1);
        }catch (MizpizException e) {
                e.printStackTrace();
                System.out.print("e");
            }
        }
      public void testInstance() throws MizpizException {
        Instance instance = new Instance();
        instance.setName("mybic");
        Myentity  myentity=EntityDao.loadbyID( EntityDao.loadbyName("bicycle"));
        instance.setEntity(myentity);
        Set<Value> valuset = new HashSet<Value>();
        List<Property> propertyList=new ArrayList<Property>();
        Set<Property> propertySet = myentity.getProperties();
          for (Property property : propertySet) {
              propertyList.add(property);
          }
        StringVal stringVal1 = new StringVal();
        StringVal stringVal2 = new StringVal();
        stringVal1.setValue("200");
        stringVal2.setValue("kohestan");
        int i = 0;
        stringVal1.setProperty(propertyList.get(0));
        stringVal2.setProperty(propertyList.get(1));
   //     Long id = ValueDao.loadbyDV("S",stringVal1.getValue());
        ValueDao.createValue(stringVal1);
   //       if (id != 0)
//              stringVal1 = (StringVal) ValueDao.loadbyID(id);
//          else
//          try {
//              ValueDao.createValue(stringVal1);
//          }catch (MizpizException e) {
//              e.printStackTrace();
//              System.out.print("e");
//          }
//          id = ValueDao.loadbyDV("S", stringVal2.getValue());
//          if (id != 0)
//              stringVal2 = (StringVal) ValueDao.loadbyID(id);
//          else try {
//              ValueDao.createValue(stringVal2);
//          }catch (MizpizException e) {
//              e.printStackTrace();
//              System.out.print("e");
//          }
//
//        valuset.add(stringVal1);
//        valuset.add(stringVal2);
//        instance.setValues(valuset);
//        InstanceDao.createInstance(instance);
    }
}
