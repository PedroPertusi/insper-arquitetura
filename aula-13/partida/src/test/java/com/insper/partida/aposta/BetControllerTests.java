package com.insper.partida.aposta;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.insper.partida.equipe.Team;
import com.insper.partida.equipe.TeamController;
import com.insper.partida.equipe.TeamService;
import com.insper.partida.game.Game;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BetControllerTests {

    MockMvc mockMvc;

    @InjectMocks
    BetController betController;

    @Mock
    BetService betService;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders
                .standaloneSetup(betController)
                .build();
    }

    @Test
    void test_listBets() throws Exception {
        Bet bet = new Bet();
        bet.setResult(BetResult.HOME);
        bet.setStatus(BetStatus.WON);

        List<Bet> bets = new ArrayList<>();
        bets.add(bet);

        Mockito.when(betService.listBets()).thenReturn(bets);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.get("/bet"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        ObjectMapper om = new ObjectMapper();
        String resp = result.getResponse().getContentAsString();
        Assertions.assertEquals(om.writeValueAsString(bets), resp);
    }

    @Test
    void test_createBets() throws Exception {
        Bet bet = new Bet();
        bet.setResult(BetResult.HOME);
        bet.setStatus(BetStatus.WON);
        bet.setId(1);

        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(bet);

        Mockito.when(betService.saveBet(bet)).thenReturn(bet);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.post("/bet")
                        .content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String resp = result.getResponse().getContentAsString();
        Assertions.assertEquals(content, resp);
    }

    @Test
    void test_verifyBets() throws Exception {
        Team team = new Team();
        team.setId(1);
        team.setIdentifier("time-1");

        Team team2 = new Team();
        team2.setId(2);
        team2.setIdentifier("time-2");

        Game game = new Game();
        game.setHome(team);
        game.setAway(team2);
        game.setIdentifier("game-1");
        game.setScoreHome(1);
        game.setScoreAway(0);

        Bet bet = new Bet();
        bet.setResult(BetResult.HOME);
        bet.setGame(game);
        bet.setId(1);


        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(bet);

        Mockito.when(betService.verifyBet(bet.getId())).thenReturn(bet);

        MvcResult result = mockMvc
                .perform(MockMvcRequestBuilders.put("/bet/1/verify")
                        .content(content).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String resp = result.getResponse().getContentAsString();
        Assertions.assertEquals(content, resp);
    }



}
