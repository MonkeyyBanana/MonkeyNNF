package stinkymonkey.NeuralNetwork.Modules;

public enum Kernels {
	EdgeDetect0("Edge Detection Filter 0", "Outline Edges", new float[][] {{-1, 0, 1}, 
																  		   {-2, 0, 2},
																           {-1, 0, 1}}),
	
	Sharpen0("Sharpen 0", "Sharpen", new float[][] {{0, -1, 0},
													{-1, 5, -1},
													{0, -1, 0}}),
	
	Blur0("Blur 0", "Blur", new float[][] {{1/9, 1/9, 1/9},
										   {1/9, 1/9, 1/9},
										   {1/9, 1/9, 1/9},});
	
	private String KERNEL_NAME;
	private String KERNEL_DESC;
	private float[][] KERNEL_WEIGHTS;
	
	Kernels(String kernel_name, String kernel_desc, float[][] kernel_weights) {
		KERNEL_NAME = kernel_name;
		KERNEL_DESC = kernel_desc;
		KERNEL_WEIGHTS = kernel_weights;
	}
	
	Kernels(float[][] kernel_weights) {
		KERNEL_NAME = new String();
		KERNEL_DESC = new String();
		KERNEL_WEIGHTS = kernel_weights;
	}
	
	public String getName() {
		return KERNEL_NAME;
	}
	
	public String getDesc() {
		return KERNEL_DESC;
	}
	
	public float[][] getWeights() {
		return KERNEL_WEIGHTS;
	}
}
