package br.com.touros.punterbot.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;

@RestController
@RolesAllowed("ADMINISTRADOR")
@RequestMapping("admin")
public class AdminController extends BaseController {



}
