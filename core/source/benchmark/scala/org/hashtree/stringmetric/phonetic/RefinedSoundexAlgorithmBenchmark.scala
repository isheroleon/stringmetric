package org.hashtree.stringmetric.phonetic

import com.google.caliper.Param
import org.hashtree.stringmetric.{ CaliperBenchmark, CaliperRunner }
import scala.util.Random

final class RefinedSoundexAlgorithmBenchmark extends CaliperBenchmark {
	@Param(Array("0", "1", "2", "4", "8", "16"))
	var length: Int = _

	var string: String = _
	var charArray: Array[Char] = _

	override protected def setUp() {
		string = Random.alphanumeric.filter(_ > '9').take(length).mkString
		charArray = string.toCharArray
	}

	def timeComputeWithCharArray(reps: Int) = run(reps) {
		RefinedSoundexAlgorithm.compute(charArray)
	}

	def timeComputeWithString(reps: Int) = run(reps) {
		RefinedSoundexAlgorithm.compute(string)
	}
}

object RefinedSoundexAlgorithmBenchmark extends CaliperRunner(classOf[RefinedSoundexAlgorithmBenchmark])