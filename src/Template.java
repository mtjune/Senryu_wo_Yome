public class Template {
	private Element[] elements;

	public Template(String str) {
		String[] el = str.split(",");
		elements = new Element[el.length];

		for (int i = 0; i < el.length; i++) {
			elements[i] = new Element(el[i]);
		}

	}

	public Element getElement(int index) {
		if (index < elements.length) {
			return elements[index];
		} else {
			return null;
		}
	}

	public int getElementLength() {
		return elements.length;
	}

	public boolean isMatchElement(Element els) {

		boolean ismatch = false;
		for (Element element : elements) {
			if (els.equals(element)) {
				ismatch = true;
				break;
			}
		}

		return ismatch;

	}

}
