package com.OficinaDeSoftware.EmissorCertificadosBackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.Evento;
import com.OficinaDeSoftware.EmissorCertificadosBackend.domain.EventoPersonalizado;
import com.OficinaDeSoftware.EmissorCertificadosBackend.service.EventoService;

@RestController
public class EventoController {
    
    @Autowired
    private EventoService service;

    @GetMapping(value = "/evento/gerenciar")
    public ResponseEntity<List<Evento>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/eventos")
    public ResponseEntity<List<EventoPersonalizado>> findAllPersonalizado() {
        return ResponseEntity.ok().body(service.findAllPersonalizado());
    }
}

// {
//     "event": {
//         "name": "Evento",
//         "dateStart": "2023-11-09T13:00",
//         "dateEnd": "2023-11-10T18:00",
//         "dates": [
//             {
//                 "date": "2023-11-09",
//                 "startTime": "13:30",
//                 "endTime": "18:00"
//             },
//             {
//                 "date": "2023-11-09",
//                 "startTime": "19:00",
//                 "endTime": "21:00"
//             },
//             {
//                 "date": "2023-11-10",
//                 "startTime": "10:00",
//                 "endTime": "12:00"
//             },
//             {
//                 "date": "2023-11-10",
//                 "startTime": "13:00",
//                 "endTime": "17:59"
//             }
//         ],
//         "workload": "8",
//         "informations": "5",
//         "nomeEmissor": "ALVARO EDUARDO MENEGON ROSARIO",
//         "certificate": {
//             "htmlModel": "",
//             "modelo": "1",
//             "personalData": {
//                 "instituicao": "Universidade Tecnológica Federal do Paraná",
//                 "local": "",
//                 "logo": {},
//                 "backgroundImage": {}
//             }
//         }
//     }
// }