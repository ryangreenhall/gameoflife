
using System;
using NUnit.Framework;
using NUnit.Framework.Constraints;
using NUnit.Framework.SyntaxHelpers;



	[TestFixture()]
	public class CellBehaviour
	{

		[Test()]
		public void knowsIfItIsAlive(){
			Assert.That(7, Is.GreaterThan(6));
		}
	}



