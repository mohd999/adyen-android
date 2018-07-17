package com.adyen.checkout.core.model;

import android.os.Parcel;
import android.support.annotation.NonNull;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Copyright (c) 2017 Adyen B.V.
 * <p>
 * This file is open source and available under the MIT license. See the LICENSE file for more info.
 * <p>
 * Created by timon on 16/11/2017.
 */
public final class QiwiWalletDetails extends PaymentMethodDetails {
    public static final Creator<QiwiWalletDetails> CREATOR = new Creator<QiwiWalletDetails>() {
        @Override
        public QiwiWalletDetails createFromParcel(Parcel source) {
            return new QiwiWalletDetails(source);
        }

        @Override
        public QiwiWalletDetails[] newArray(int size) {
            return new QiwiWalletDetails[size];
        }
    };

    public static final String KEY_TELEPHONE_NUMBER_PREFIX = "qiwiwallet.telephoneNumberPrefix";

    public static final String KEY_TELEPHONE_NUMBER = "qiwiwallet.telephoneNumber";

    private String mTelephoneNumberPrefix;

    private String mTelephoneNumber;

    private QiwiWalletDetails() {
        // Empty constructor for Builder.
    }

    private QiwiWalletDetails(@NonNull Parcel in) {
        super(in);

        mTelephoneNumberPrefix = in.readString();
        mTelephoneNumber = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTelephoneNumberPrefix);
        dest.writeString(mTelephoneNumber);
    }

    @NonNull
    @Override
    public JSONObject serialize() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(KEY_TELEPHONE_NUMBER_PREFIX, mTelephoneNumberPrefix);
        jsonObject.put(KEY_TELEPHONE_NUMBER, mTelephoneNumber);

        return jsonObject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        QiwiWalletDetails that = (QiwiWalletDetails) o;

        if (mTelephoneNumberPrefix != null ? !mTelephoneNumberPrefix.equals(that.mTelephoneNumberPrefix) : that.mTelephoneNumberPrefix != null) {
            return false;
        }
        return mTelephoneNumber != null ? mTelephoneNumber.equals(that.mTelephoneNumber) : that.mTelephoneNumber == null;
    }

    @Override
    public int hashCode() {
        int result = mTelephoneNumberPrefix != null ? mTelephoneNumberPrefix.hashCode() : 0;
        result = 31 * result + (mTelephoneNumber != null ? mTelephoneNumber.hashCode() : 0);
        return result;
    }

    public static final class Builder {
        private final QiwiWalletDetails mQiwiWalletDetails;

        public Builder(@NonNull String telephoneNumberPrefix, @NonNull String telephoneNumber) {
            mQiwiWalletDetails = new QiwiWalletDetails();
            mQiwiWalletDetails.mTelephoneNumberPrefix = telephoneNumberPrefix;
            mQiwiWalletDetails.mTelephoneNumber = telephoneNumber;
        }

        @NonNull
        public QiwiWalletDetails build() {
            return mQiwiWalletDetails;
        }
    }
}
