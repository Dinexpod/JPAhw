package mate.academy.jpahw.dao;

import mate.academy.jpahw.dao.crud.CrudDao;
import mate.academy.jpahw.models.devices.Device;
import mate.academy.jpahw.models.patients.Patient;
import mate.academy.jpahw.models.tests.Test;

public interface DeviceDao extends CrudDao<Device, Long> {
    Test doTest(Patient patient);
}
