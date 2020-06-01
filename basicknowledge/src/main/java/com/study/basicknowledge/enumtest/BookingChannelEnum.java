package com.study.basicknowledge.enumtest;

import lombok.Getter;

/**
 * 引擎类型
 *
 * @author xfyuan
 * @date 2019/5/29
 */
public enum BookingChannelEnum {
    /**
     * No need pnr
     */
    NO_NEED_PNR("NNP-WS"),
    /**
     * Not support engine
     */
    NOT_SUPPORT_ENGINE("NSE-WS"),
    /**
     * GDS
     */
    CTRIP("GDS-WS"),
    /**
     * 1B
     */
    ABACUS("1B-WS"),
    /**
     * JS
     */
    JETSTAR("JS-WS"),
    /**
     * TF
     */
    TRAVEL_FUSION("TF-WS"),
    /**
     * CS
     */
    SPRING("CS-WS"),
    /**
     * 1A
     */
    AMADEUS("1A-WS"),
    /**
     * TSK
     */
    TSK("TS-WS"),
    /**
     * ZY
     */
    SHARED_PLATFORM("ZY-WS"),
    /**
     * IJ
     */
    SPRING_JAPAN("IJ-WS"),
    /**
     * CSD
     */
    CONSOLIDATOR("CSD-WS"),
    /**
     * CW
     */
    AIRCHINA("CW-WS"),
    /**
     * HX
     */
    HK_AIRLINES("HX-WS"),
    /**
     * KW
     */
    CHARTER_PLATFORM("KW-WS"),
    /**
     * CZD
     */
    CZ_AIRLINES("CZD-WS"),
    /**
     * MUC
     */
    MUC_AIRLINES("MUC-WS"),
    /**
     * MUT
     */
    MUT_AIRLINES("MUT-WS"),
    /**
     * 3UD
     */
    AIRLINES_3U("3UD-WS"),
    /**
     * ZHD
     */
    ZH_AIRLINES("ZHD-WS"),
    MUG_AIRLINES("MUG-WS"),
    /**
     * HUD
     */
    HUD_AIRLINES("HUD-WS"),
    DOMESTIC_AGG("DMC-WS"),
    /**
     * 1G
     */
    GALILEO("1G-WS"),
    /**
     * JDD
     */
    JD_AIRLINES("JDD-WS"),
    /**
     * PRICING
     */
    PRICING("PRC-WS"),
    QUNAR("QNR-WS"),
    /**
     * AVIA
     */
    AVIA_AIRLINES("AVIA-WS"),
    /**
     * G5D
     */
    G5D_AIRLINES("G5D-WS"),
    /**
     * QTB
     */
    ETERM_QTB("QTB-1E"),
    /**
     * 天航引擎
     */
    GSD_AIRLINES("GSD-WS"),
    /**
     * MMT
     */
    MAKE_MY_TRIP("MMT-WS"),
    /**
     * 祥鹏引擎 8LD
     */
    AIRLINE_8LD("8LD-WS");


    @Getter
    private final String value;

    BookingChannelEnum(String value) {
        this.value = value;
    }
}
