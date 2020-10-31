package com.proximastudio.bola.repo

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class PostModel(
        @SerializedName("teams")
        val teams: List<Team>
)

data class Team(
        @SerializedName("idTeam")
        var teamId: String? = null,

        @SerializedName("strTeam")
        var teamName: String? = null,

        @SerializedName("strSport")
        var teamSport: String? = null,

        @SerializedName("strTeamBadge")
        var teamBadge: String? = null,

        @SerializedName("strDescriptionEN")
        var teamDesc: String? = null,

        @SerializedName("intFormedYear")
        var teamFormedYear: String? = null,

        @SerializedName("strStadium")
        var teamStadium: String? = null,

        @SerializedName("strStadiumThumb")
        var teamStadiumImage: String? = null
) : Parcelable {
        constructor(parcel: Parcel) : this(
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString(),
                parcel.readString()) {
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeString(teamId)
                parcel.writeString(teamName)
                parcel.writeString(teamSport)
                parcel.writeString(teamBadge)
                parcel.writeString(teamDesc)
                parcel.writeString(teamFormedYear)
                parcel.writeString(teamStadium)
                parcel.writeString(teamStadiumImage)
        }

        override fun describeContents(): Int {
                return 0
        }

        companion object CREATOR : Parcelable.Creator<Team> {
                override fun createFromParcel(parcel: Parcel): Team {
                        return Team(parcel)
                }

                override fun newArray(size: Int): Array<Team?> {
                        return arrayOfNulls(size)
                }
        }
}