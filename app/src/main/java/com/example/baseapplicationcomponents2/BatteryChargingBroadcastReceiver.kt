package com.example.baseapplicationcomponents2

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.BatteryManager
import android.widget.ImageView


class BatteryChargingBroadcastReceiver(private val imageView: ImageView) : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        fun isPhonePluggedIn(): Boolean {
            var charging = false
            val status = intent!!.getIntExtra(BatteryManager.EXTRA_STATUS, -1)
            val batteryCharge = status == BatteryManager.BATTERY_STATUS_CHARGING
            val chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1)
            val usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB
            val acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC
            if (batteryCharge || usbCharge || acCharge) charging = true
            return charging
        }
        //val batteryManager = context!!.getSystemService(Context.BATTERY_SERVICE) as BatteryManager

        if (isPhonePluggedIn()) imageView.setImageResource(R.drawable.ic_charging_battery)
        else imageView.setImageResource(R.drawable.ic_battery)
    }
}