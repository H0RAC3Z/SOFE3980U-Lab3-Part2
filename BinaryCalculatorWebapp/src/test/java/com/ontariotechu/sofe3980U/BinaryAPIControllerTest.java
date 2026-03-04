package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void add1() throws Exception {
        this.mvc.perform(get("/add").param("operand1","1000").param("operand2","1111"))
            .andExpect(status().isOk())
            .andExpect(content().string("10111"));
    }

    @Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add").param("operand1","1010").param("operand2","11"))
            .andExpect(status().isOk())
            .andExpect(content().string("1101"));
    }

    @Test
    public void add3() throws Exception {
        this.mvc.perform(get("/add").param("operand1","11").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(content().string("1101"));
    }

    @Test
    public void add4() throws Exception {
        this.mvc.perform(get("/add").param("operand1","0").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(content().string("1010"));
    }

    @Test
    public void add5() throws Exception {
        this.mvc.perform(get("/add").param("operand1","0").param("operand2","0"))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }

    @Test
    public void add_json1() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","1000").param("operand2","1111"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(1000))
            .andExpect(jsonPath("$.operand2").value(1111))
            .andExpect(jsonPath("$.result").value(10111))
            .andExpect(jsonPath("$.operator").value("add"));
    }

    @Test
    public void add_json2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","1010").param("operand2","11"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(1010))
            .andExpect(jsonPath("$.operand2").value(11))
            .andExpect(jsonPath("$.result").value(1101))
            .andExpect(jsonPath("$.operator").value("add"));
    }

    @Test
    public void add_json3() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","11").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(11))
            .andExpect(jsonPath("$.operand2").value(1010))
            .andExpect(jsonPath("$.result").value(1101))
            .andExpect(jsonPath("$.operator").value("add"));
    }

    @Test
    public void add_json4() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","0").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(0))
            .andExpect(jsonPath("$.operand2").value(1010))
            .andExpect(jsonPath("$.result").value(1010))
            .andExpect(jsonPath("$.operator").value("add"));
    }

    @Test
    public void add_json5() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","0").param("operand2","0"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(0))
            .andExpect(jsonPath("$.operand2").value(0))
            .andExpect(jsonPath("$.result").value(0))
            .andExpect(jsonPath("$.operator").value("add"));
    }

    @Test
    public void or1() throws Exception {
        this.mvc.perform(get("/or").param("operand1","1000").param("operand2","1111"))
            .andExpect(status().isOk())
            .andExpect(content().string("1111"));
    }

    @Test
    public void or2() throws Exception {
        this.mvc.perform(get("/or").param("operand1","1010").param("operand2","11"))
            .andExpect(status().isOk())
            .andExpect(content().string("1011"));
    }

    @Test
    public void or3() throws Exception {
        this.mvc.perform(get("/or").param("operand1","11").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(content().string("1011"));
    }

    @Test
    public void or4() throws Exception {
        this.mvc.perform(get("/or").param("operand1","0").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(content().string("1010"));
    }

    @Test
    public void or5() throws Exception {
        this.mvc.perform(get("/or").param("operand1","0").param("operand2","0"))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }

    @Test
    public void or_json1() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","1000").param("operand2","1111"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(1000))
            .andExpect(jsonPath("$.operand2").value(1111))
            .andExpect(jsonPath("$.result").value(1111))
            .andExpect(jsonPath("$.operator").value("or"));
    }

    @Test
    public void or_json2() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","1010").param("operand2","11"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(1010))
            .andExpect(jsonPath("$.operand2").value(11))
            .andExpect(jsonPath("$.result").value(1011))
            .andExpect(jsonPath("$.operator").value("or"));
    }

    @Test
    public void or_json3() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","11").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(11))
            .andExpect(jsonPath("$.operand2").value(1010))
            .andExpect(jsonPath("$.result").value(1011))
            .andExpect(jsonPath("$.operator").value("or"));
    }

    @Test
    public void or_json4() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","0").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(0))
            .andExpect(jsonPath("$.operand2").value(1010))
            .andExpect(jsonPath("$.result").value(1010))
            .andExpect(jsonPath("$.operator").value("or"));
    }

    @Test
    public void or_json5() throws Exception {
        this.mvc.perform(get("/or_json").param("operand1","0").param("operand2","0"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(0))
            .andExpect(jsonPath("$.operand2").value(0))
            .andExpect(jsonPath("$.result").value(0))
            .andExpect(jsonPath("$.operator").value("or"));
    }

    @Test
    public void and1() throws Exception {
        this.mvc.perform(get("/and").param("operand1","1000").param("operand2","1111"))
            .andExpect(status().isOk())
            .andExpect(content().string("1000"));
    }

    @Test
    public void and2() throws Exception {
        this.mvc.perform(get("/and").param("operand1","1010").param("operand2","11"))
            .andExpect(status().isOk())
            .andExpect(content().string("10"));
    }

    @Test
    public void and3() throws Exception {
        this.mvc.perform(get("/and").param("operand1","11").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(content().string("10"));
    }

    @Test
    public void and4() throws Exception {
        this.mvc.perform(get("/and").param("operand1","0").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }

    @Test
    public void and5() throws Exception {
        this.mvc.perform(get("/and").param("operand1","0").param("operand2","0"))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }


    @Test
    public void and_json1() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","1000").param("operand2","1111"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(1000))
            .andExpect(jsonPath("$.operand2").value(1111))
            .andExpect(jsonPath("$.result").value(1000))
            .andExpect(jsonPath("$.operator").value("and"));
    }

    @Test
    public void and_json2() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","1010").param("operand2","11"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(1010))
            .andExpect(jsonPath("$.operand2").value(11))
            .andExpect(jsonPath("$.result").value(10))
            .andExpect(jsonPath("$.operator").value("and"));
    }

    @Test
    public void and_json3() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","11").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(11))
            .andExpect(jsonPath("$.operand2").value(1010))
            .andExpect(jsonPath("$.result").value(10))
            .andExpect(jsonPath("$.operator").value("and"));
    }

    @Test
    public void and_json4() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","0").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(0))
            .andExpect(jsonPath("$.operand2").value(1010))
            .andExpect(jsonPath("$.result").value(0))
            .andExpect(jsonPath("$.operator").value("and"));
    }

    @Test
    public void and_json5() throws Exception {
        this.mvc.perform(get("/and_json").param("operand1","0").param("operand2","0"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(0))
            .andExpect(jsonPath("$.operand2").value(0))
            .andExpect(jsonPath("$.result").value(0))
            .andExpect(jsonPath("$.operator").value("and"));
    }

    @Test
    public void multiply1() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1","1000").param("operand2","1111"))
            .andExpect(status().isOk())
            .andExpect(content().string("1111000"));
    }

    @Test
    public void multiply2() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1","1010").param("operand2","11"))
            .andExpect(status().isOk())
            .andExpect(content().string("11110"));
    }

    @Test
    public void multiply3() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1","11").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(content().string("11110"));
    }

    @Test
    public void multiply4() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1","0").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }

    @Test
    public void multiply5() throws Exception {
        this.mvc.perform(get("/multiply").param("operand1","0").param("operand2","0"))
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
    }

    @Test
    public void multiply_json1() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1","1000").param("operand2","1111"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(1000))
            .andExpect(jsonPath("$.operand2").value(1111))
            .andExpect(jsonPath("$.result").value(1111000))
            .andExpect(jsonPath("$.operator").value("multiply"));
    }

    @Test
    public void multiply_json2() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1","1010").param("operand2","11"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(1010))
            .andExpect(jsonPath("$.operand2").value(11))
            .andExpect(jsonPath("$.result").value(11110))
            .andExpect(jsonPath("$.operator").value("multiply"));
    }

    @Test
    public void multiply_json3() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1","11").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(11))
            .andExpect(jsonPath("$.operand2").value(1010))
            .andExpect(jsonPath("$.result").value(11110))
            .andExpect(jsonPath("$.operator").value("multiply"));
    }

    @Test
    public void multiply_json4() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1","0").param("operand2","1010"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(0))
            .andExpect(jsonPath("$.operand2").value(1010))
            .andExpect(jsonPath("$.result").value(0))
            .andExpect(jsonPath("$.operator").value("multiply"));
    }

    @Test
    public void multiply_json5() throws Exception {
        this.mvc.perform(get("/multiply_json").param("operand1","0").param("operand2","0"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.operand1").value(0))
            .andExpect(jsonPath("$.operand2").value(0))
            .andExpect(jsonPath("$.result").value(0))
            .andExpect(jsonPath("$.operator").value("multiply"));
    }
}