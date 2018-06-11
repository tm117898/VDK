package com.vargo.vdk.example;

import com.vargo.vdk.base.application.ViewModelApplication;
import com.vargo.vdk.base.model.BaseModel;
import com.vargo.vdk.base.model.ModelBaseFactory;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/08 10:37
 */
public class ModelFactory extends ModelBaseFactory {
    public ModelFactory(ViewModelApplication a) {
        super(a);
    }

    @Override
    protected <T extends BaseModel> T onCreate(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(DownloadModel.class)) {
            return (T) new DownloadModel(getApplication());
        }
        return null;
    }
}
