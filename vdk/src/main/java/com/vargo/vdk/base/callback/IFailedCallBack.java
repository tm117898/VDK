package com.vargo.vdk.base.callback;

/**
 * <br/>
 * <li>Author Cesc Shang
 * <li>Email shanghaolongteng@vargo.com.cn
 * <li>Date 2018/06/08 13:41
 */
public interface IFailedCallBack<SuccessResult, FailedResult> extends ISuccessCallBack<SuccessResult> {
    void failed(FailedResult r);
}
