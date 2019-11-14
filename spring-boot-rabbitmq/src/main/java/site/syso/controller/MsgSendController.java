package site.syso.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import site.syso.component.MsgSender;

@RestController
public class MsgSendController {

    @Autowired
    private MsgSender msgSender;

    @GetMapping("/queue")
    public String send(@RequestParam String message) {
        msgSender.queue(message);
        return "success";
    }

    @GetMapping("/topic")
    public String topic(@RequestParam String message) {
        msgSender.topic(message);
        return "success";
    }

}
