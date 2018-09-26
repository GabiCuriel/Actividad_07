package main;

import view.ViewGyA;
import model.ModelGyA;
import controller.ControllerGyA;

public class MainGyA {
    private static ViewGyA viewGyA;
    private static ModelGyA modelGyA;
    private static ControllerGyA controllerGyA;
    
    public static void main(String[] args)
    {
        viewGyA = new ViewGyA();
        modelGyA = new ModelGyA();
        controllerGyA = new ControllerGyA(viewGyA, modelGyA);
    }
}