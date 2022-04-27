package stinkymonkey.NeuralNetwork;

public abstract class BaseLayer {
	public int input_layers;
	public int output_layers;
	public Activator net_activator;
	
	public BaseLayer(int inputLayers, int outputLayers, Activator activator) {
		input_layers = inputLayers;
		output_layers = outputLayers;
		net_activator = activator;
	}
	
	public abstract float[] feedForward(float[] inputs);
}
