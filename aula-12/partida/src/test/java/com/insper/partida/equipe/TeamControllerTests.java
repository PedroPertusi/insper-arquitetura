package com.insper.partida.equipe;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class TeamControllerTests {

    MockMvc mockMvc; //classe do spring simula um servidor pra chamar as rotas

    @InjectMocks
    TeamController teamController;

    @Mock
    TeamService teamService;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(teamController)
                .build();
    }

    @Test
    void test_listTeams() throws Exception {

        Team team = new Team();
        team.setId(1);
        team.setIdentifier("time-1");

        List<Team> times = new ArrayList<>();
        times.add(team);

        Mockito.when(teamService.listTeams()).thenReturn(times);

        MvcResult result = mockMvc //chama no metodo get e fala oq ela deve retornar
                .perform(MockMvcRequestBuilders.get("/team"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn(); //json que retona

        ObjectMapper om = new ObjectMapper();

        String resp = result.getResponse().getContentAsString();
        Assertions.assertEquals(om.writeValueAsString(times), resp); //compara o json retornado pelo oq eu espero

    }

    @Test
    void test_saveTeam() {

        Team team = new Team();
        team.setId(1);
        team.setName("time-1");

        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(team)

        Mockito.when(teamService.saveTeam(team)).thenReturn(team); //pra usar o team tem que criar a equals
        Mockito.when(teamService.saveTeam(Mockito.any())).thenReturn(team); //mockito any ajuda em erros de esperado

        MvcResult result = mockMvc //chama no metodo get e fala oq ela deve retornar
                .perform(MockMvcRequestBuilders.post("/team").content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk()) //isCreated() --> 201, is2xxSucessfull --> generico
                .andReturn(); //json que retona

        String resp = result.getResponse().getContentAsString();
        Assertions.assertEquals(content, resp);
    }




}
