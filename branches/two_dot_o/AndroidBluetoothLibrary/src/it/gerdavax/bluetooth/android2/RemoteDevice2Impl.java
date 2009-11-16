package it.gerdavax.bluetooth.android2;

import it.gerdavax.bluetooth.BtSocket;

import java.io.IOException;
import java.util.UUID;

import android.bluetooth.BluetoothDevice;


class RemoteDevice2Impl implements it.gerdavax.bluetooth.RemoteDevice {
	private BluetoothDevice bd = null;
	private int rssi = -1;
	
	RemoteDevice2Impl(BluetoothDevice _rbd, int _rssi) {
		super();
		this.bd = _rbd;
		rssi = _rssi;
	}
	
	/* (non-Javadoc)
	 * @see it.gerdavax.bluetooth.RemoteInterface#getFriendlyName()
	 */
	public String getFriendlyName() {
		return bd.getName();
	}
	
	/* (non-Javadoc)
	 * @see it.gerdavax.bluetooth.RemoteInterface#getAddress()
	 */
	public String getAddress() {
		return bd.getAddress();
	}

	@Override
	public BtSocket openSocket(UUID serviceId) throws IOException {
		BtSocket socket = new BtSocket2Impl(bd.createRfcommSocketToServiceRecord(serviceId) );
		return socket;
	}
	
	public int getRSSI() {
		return rssi;
	}
}
