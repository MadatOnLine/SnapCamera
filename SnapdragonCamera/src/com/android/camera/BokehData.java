package com.android.camera;

import android.location.Location;
import com.android.camera.exif.ExifInterface;

import com.adobe.xmp.XMPException;
import com.adobe.xmp.XMPMeta;
import com.adobe.xmp.XMPMetaFactory;


public class BokehData {
    public final static String WA_NAMESPACE_URL = "http://ns.westalgo.com/photos/1.0/image/";
    public final static String WA_PREFIX = "WAImage";
    public final static String WA_ORI_IMAGE_LENGTH = "OriImageLength";
    public final static String WA_CLEAR_IMAGE_LENGTH = "ClearImageLength";
    public final static String WA_DEPTH_LENGTH = "DepthLength";
    public final static String WA_DOF_X = "DofX";
    public final static String WA_DOF_Y = "DofY";
    public final static String WA_DOF_LEVEL = "DofLevel";

    public final static int WA_DEPTH_SIZE = 520 * 391 * 4;
    public final static boolean WA_DUAL_CAM_SUPPORTED = true;

    static {
        try {
            XMPMetaFactory.getSchemaRegistry().registerNamespace(
                    WA_NAMESPACE_URL, WA_PREFIX);
        } catch (XMPException e) {
            e.printStackTrace();
        }
    }


    public String title;
    public long date;
    public Location location;
    public int width;
    public int height;
    public int orientation;
    public ExifInterface exif;
    public String picFormat;
    public byte[] bokehJpegData;
    public byte[] oriJpegData;
    public byte[] dualCameraData;
    public int focusX;
    public int focusY;
    public double blurLevel;

    public boolean readyToSave() {
        return oriJpegData != null && dualCameraData != null && bokehJpegData != null;
    }

    public void clear() {
        oriJpegData = null;
        dualCameraData = null;
        bokehJpegData = null;
    }
}
