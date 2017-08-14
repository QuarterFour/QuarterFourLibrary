package com.a.quarter.presenter;

import com.a.quarter.model.base.BaseObserver;
import com.a.quarter.model.base.BasePresenter;
import com.a.quarter.model.bean.SatinCommentBean;
import com.a.quarter.model.utils.Httputils;
import com.a.quarter.view.iview.SatinCommentView;

import io.reactivex.Observable;

/**
 * 姓名：孙盼盼
 * 时间：2017/8/12
 * 类用途：段子评论的presenter
 * 思路：
 */

public class SatinCommentPresenter  extends BasePresenter<SatinCommentView>{

    public void getSatinCommentData(int commentCharacterPictureMediaId,int commentDictionaryValue){

        Observable<SatinCommentBean> satinComment = Httputils.getApi().getSatinComment(commentCharacterPictureMediaId,commentDictionaryValue);

        Httputils.retrofitUtils(satinComment, new BaseObserver<SatinCommentBean>(context()) {
            @Override
            public void success(SatinCommentBean satinCommentBean) {
                getBaseview().getCallBackSatinComment(satinCommentBean);
            }
        });

    }

}
