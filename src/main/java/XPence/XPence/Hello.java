/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package XPence.XPence;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Crush
 */
@RestController
public class Hello {

    @GetMapping("/")
    public String hello() {
        return "Heloooo";
    }
}
