package stinkymonkey.NeuralNetwork.Layers;

import stinkymonkey.NeuralNetwork.Activator;
import stinkymonkey.NeuralNetwork.BaseLayer;
import stinkymonkey.NeuralNetwork.MColor;
import stinkymonkey.NeuralNetwork.Modules.Kernels;

public class ConvLayer extends BaseLayer {
	private Kernels base_kernel;
	private Activator activator;
	
	private int origin_kernel_x, origin_kernel_y;
	
	float[] outputs;
	float[] inputs;
	float[][] kernel_weights;
	float[][] kernel_weights_delta;
	float[] bias;
	float[] biasDelta;
	float[] gamma;
	float[] error;

	// Kernal W/L, Stide (Movement of pixels), Puddity (BORDER BOOL)
	public ConvLayer(int inputLayers, int outputLayers, Activator activator) {
		super(inputLayers, outputLayers, activator);
		
		
	}

	@Override
	public float[] feedForward(float[] inputs) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public MColor[][] conv2d(MColor[][] input) {
		
	}
}
