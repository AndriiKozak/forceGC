/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.forcegc;


import java.lang.ref.WeakReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Andrii_Kozak1
 */
@Controller
public class ForceGCController {
    @Autowired
    private GCService gcService;
    @RequestMapping("forceGC")
    public String forceGC(Model model){        
        WeakReference<Object> ref =new WeakReference<>(new Object());
        gcService.gc();
        String result =(ref.get()==null)?"garbage collection forced":"failed to force garbage collection";
        model.addAttribute("result", result);
        return "forceGC";
    }
}
