
package com.example.test.demo.design.patterns.build.factory.normal;

import com.example.test.demo.design.patterns.build.factory.EnumPhoneType;
import com.example.test.demo.design.patterns.build.factory.HuaWeiPhone;
import com.example.test.demo.design.patterns.build.factory.Phone;
import com.example.test.demo.design.patterns.build.factory.XiaoMiPhone;
import com.example.test.demo.design.patterns.build.factory.simple.SimpleFactory;

/**
 * @author caizq
 * @date 2019/3/14
 * @since v1.0.0
 */
public class HighClassFactory implements Factory {
    private volatile static HighClassFactory instance;

    private HighClassFactory() {
    }

    public static HighClassFactory getInstance() {
        if (instance == null) {
            synchronized (SimpleFactory.class) {
                if (instance == null) {
                    instance = new HighClassFactory();
                    return instance;
                }
            }
        }
        return instance;
    }

    @Override
    public Phone create(EnumPhoneType phoneType) {
        switch (phoneType) {
            case MI:
                XiaoMiPhone xiaoMiPhone = new XiaoMiPhone();
                xiaoMiPhone.setExtStr("高档");
                return xiaoMiPhone;
            case HUA:
                HuaWeiPhone huaWeiPhone = new HuaWeiPhone();
                huaWeiPhone.setExtStr("高档");
                return huaWeiPhone;
            default:
                throw new RuntimeException();
        }
    }


}
