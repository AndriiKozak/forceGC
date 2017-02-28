/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.forcegc;

import org.springframework.stereotype.Service;

/**
 *
 * @author Andrii_Kozak1
 */
@Service
public class GCService {
    public void gc(){
        forceGarbageCollection();
    }
    private static native void forceGarbageCollection();
}
