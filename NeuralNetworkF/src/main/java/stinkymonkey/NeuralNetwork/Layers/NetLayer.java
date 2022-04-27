package stinkymonkey.NeuralNetwork.Layers;

import java.util.Random;

import stinkymonkey.NeuralNetwork.Activator;
import stinkymonkey.NeuralNetwork.BaseLayer;
import stinkymonkey.NeuralNetwork.Utils;

public class NetLayer extends BaseLayer {
	private Random random = new Random(1);
	
	public float MIN_BIAS = 0.0f;
	public float MAX_BIAS = 0.0f;
	
	public float LEARNING_RATE = 0.0333f;
	
	float[] outputs;
	float[] inputs;
	float[][] weights;
	float[][] weightsDelta;
	float[] bias;
	float[] biasDelta;
	float[] gamma;
	float[] error;
	
	public NetLayer(int inputLayers, int outputLayers, Activator activator) {
		super(inputLayers, outputLayers, activator);
		
		outputs = new float[output_layers];
		inputs = new float[input_layers];
		weights = new float[output_layers][input_layers];
		weightsDelta = new float[output_layers][input_layers];
		bias = new float[output_layers];
		biasDelta = new float[output_layers];
		gamma = new float[output_layers];
		error = new float[output_layers];
		
		initWeights();
	}
	
	public void initWeights() {
		for (int i = 0; i < output_layers; i++) {
			for (int j = 0; j < input_layers; j++) {
				weights[i][j] = random.nextFloat() - 0.5f;
			}
			bias[i] = MIN_BIAS + (MAX_BIAS - MIN_BIAS) * random.nextFloat();
		}
	}
	
	@Override
	public float[] feedForward(float[] inputs) {
		this.inputs = inputs;
		
		for (int i = 0; i < output_layers; i++) {
			outputs[i] = 0;
			
			for (int j = 0; j < input_layers; j++) {
				outputs[i] += inputs[j] * weights[i][j];
			}
			
			outputs[i] += bias[i];
			outputs[i] = net_activator.activator(outputs[i]);
		}
		
		return outputs;
	}
	
	public void backpropOutput(float[] expected) {
		for (int i = 0; i < output_layers; i++)
			error[i] = outputs[i] - expected[i];
		
		for (int i = 0; i < output_layers; i++) 
			gamma[i] = error[i] * Utils.Deriv(outputs[i]);
		
		for (int i = 0; i < output_layers; i++) {
			for (int j = 0; j < input_layers; j++)
				weightsDelta[i][j] = gamma[i] * inputs[j];
			
			biasDelta[i] = gamma[i] * bias[i];
		}
	}
	
	public void backpropHidden(float[] gammaForward, float[][] weightsForward) {
		for (int i = 0; i < output_layers; i++) {
			gamma[i] = 0;
			
			for (int j = 0; j < gammaForward.length; j++)
				gamma[i] += gammaForward[j] * weightsForward[j][i];
			
			gamma[i] *= Utils.Deriv(outputs[i]);
		}
		
		for (int i = 0; i < output_layers; i++) {
			for (int j = 0; j < input_layers; j++)
				weightsDelta[i][j] = gamma[i] * inputs[j];
			
			biasDelta[i] = gamma[i] * bias[i];
		}
	}
	
	public void UpdateWeights() {
		for (int i = 0; i < output_layers; i++) {
			for (int j = 0; j < input_layers; j++) 
				weights[i][j] -= weightsDelta[i][j] * LEARNING_RATE;
			
			bias[i] -= biasDelta[i] * LEARNING_RATE;
		}
	}
}
