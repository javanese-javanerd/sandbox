package Quizzes;

public class UsingSuper {

	class LongObj {

		private int m_length;

		LongObj(int length) {
			m_length = length;
		}

	}

	class LongAndWideObj extends LongObj {

		private int m_width;
		
		/**
		 * Super class' constructor must be called first in a subclass' constructor before any other statement.
		 * 
		 * @param width
		 * @param length
		 */
		LongAndWideObj(int width, int length) {
			super(length);
			m_width = width;
		}

	}

}
