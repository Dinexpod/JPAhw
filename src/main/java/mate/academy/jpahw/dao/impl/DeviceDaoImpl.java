package mate.academy.jpahw.dao.impl;

import mate.academy.jpahw.dao.DeviceDao;
import mate.academy.jpahw.dao.abstractDao.AbstractDao;
import mate.academy.jpahw.models.devices.Device;

import javax.persistence.EntityManager;

public class DeviceDaoImpl extends AbstractDao<Device, Long> implements DeviceDao {
    public DeviceDaoImpl(EntityManager em, Class<Device> deviceClass) {
        super(em, deviceClass);
    }
}
