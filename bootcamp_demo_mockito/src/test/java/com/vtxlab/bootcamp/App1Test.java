package com.vtxlab.bootcamp;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS);
public class App1Test {

    @Mock
    private App2 dependency; // we didn't create object

    @BeforeAll
    void init() {
        dependency = mock(App2.class);
        when(dependency.encode('a')).thenReturn('B');
        when(dependency.encode('b')).thenReturn('C');
        when(dependency.encode('c')).thenReturn('D');
        when(dependency.encode('d')).thenReturn('E');
        when(dependency.encode('e')).thenReturn('F');
        when(dependency.encode('f')).thenReturn('G');
        when(dependency.encode('g')).thenReturn('H');
    }

    @Test
    void testAdd_whenApp2ProviderMethodAlwayasReturn100() {

        // Case 1 : x <= 10 && y > 20

        int x = 10, y = 19;

        // if someone call dependency.provider(20, 19), return -100
        Mockito.when(dependency.provider(x * 2, 19)).thenReturn(100);

        //
        App1 app1 = new App1(dependency);

        // Actual call (unit test start point)
        int result = app1.add(x, y);

        // the case is actually testing the rest of the logic (+1000)
        assertEquals(677, result);

        // Case 2 : x > 10 && y > 20
        // Case 3 : x <= 10 && y <= 20
        // Case 4 : x > 10 && y <= 20

    
    }
    @Test
    void testFirstCharacters() {
        App1 app1 = new App1(dependency);
        List<String> strings = new ArrayList<>(List.of("abc", "def", "cba", "kba"));
        String result = app1.firstCharacers(strings);
        assertEquals()
    }
}