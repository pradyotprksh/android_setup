package com.pradyotprkshprksh.home.presenter.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Todo() : Parcelable {
    @SerializedName("id")
    var id: String? = ""
    @SerializedName("description")
    var description: String? = ""
    @SerializedName("scheduledDate")
    var scheduledDate: String? = ""
    @SerializedName("status")
    var status: String? = "PENDING"

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        description = parcel.readString()
        scheduledDate = parcel.readString()
        status = parcel.readString()
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(dest: Parcel?, flags: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<Todo> {
        override fun createFromParcel(parcel: Parcel): Todo {
            return Todo(parcel)
        }

        override fun newArray(size: Int): Array<Todo?> {
            return arrayOfNulls(size)
        }
    }
}
